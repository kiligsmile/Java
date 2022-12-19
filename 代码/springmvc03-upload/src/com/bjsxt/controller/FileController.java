package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import com.bjsxt.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/FileController")
public class FileController {

    @Autowired
    UserService  userService;


    //下载指定文件
    @RequestMapping("/fileDownLoad")
    public   void    fileDownLoad(String  filetype,HttpServletResponse  resp, HttpServletRequest req, String filename) throws IOException {

        //服务器目录
        String realPath = req.getServletContext().getRealPath("/imgs");



        File  file=new File(realPath+"/"+filename);

        resp.setContentLength((int) file.length());

        resp.setContentType(filetype);

        resp.setHeader("Content-Disposition","attachment;filename="+filename);



        //【A】从服务器中读取需要下载的文件
        InputStream  input=new FileInputStream(file);

        //【B】把文件写到本地硬盘
          OutputStream  ouput=resp.getOutputStream();

        IOUtils.copy(input,ouput);

        ouput.close();

        input.close();
    }



    //查询所有用户

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){

        return  userService.findAll();
    }


    //文件上传的方法
    @RequestMapping("/fileUpLoad")
    public  String  fileUpLoad(HttpServletRequest  req, User user, MultipartFile  fil) throws IOException {

        //System.out.println(uname+"--"+pwd+"--"+score);
        //fil--fl.jpg--18004---image/jpeg
        //System.out.println(fil.getName()+"--"+fil.getOriginalFilename()+"--"+fil.getSize()+"---"+fil.getContentType());

        //System.out.println(fil.getContentType());


        String uuid = UUID.randomUUID().toString();

        String substring = fil.getOriginalFilename().substring(fil.getOriginalFilename().lastIndexOf("."));
        /**E、判断上传文件的名称*/
        if(!(".jpg".equals(substring)||".png".equals(substring)||".gif".equals(substring))){

            req.setAttribute("msg","文件类型不匹配");
            return  "/save.jsp";
        }

        /***D、设置文件的大小**/
       /* if(fil.getSize()>20*1024){

            req.setAttribute("msg","文件最大是20k");
            return  "forward:/save.jsp";
        }*/

        /**C、文件名称不重复**/

         String  filename=uuid+substring;


        /****B、获得服务器的目录*/
        String realPath = req.getServletContext().getRealPath("/imgs");

        System.out.println(realPath);

        /*****A、自动创建目录********/
          File  file=new File(realPath);

          if(!file.exists()){

              file.mkdirs();
          }


         fil.transferTo(new File(file,filename));


          //添加操作
        user.setFilename(filename);
        user.setFileType(fil.getContentType());

        int i = userService.save(user);

        if(i>0){
            return "redirect:/success.jsp";
        }else {

             req.setAttribute("msg","添加失败");
            return "forward:/save.jsp";
        }



    }
}

/**
 *   遇到的问题：
 *
 *   1、上传文件的时候名字中文乱码：
 *
 *    <property name="defaultEncoding" value="utf-8"></property>
 *
 *   2、上传的文件夹名称必须给出:

       file.exists()
 *   3、上传不到当前服务器的路径中:
 *     String realPath = req.getServletContext().getRealPath("/imgs");

 *   4、相同的图片名称会覆盖:
 *       UUID
 *   5、无法指定上传图片的大小:

 *   6、无法指定上传文件的类型:
 *
 *
 * */
