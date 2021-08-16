package 通讯录管理系统;
import java.util.Random;
// 生成多个用户
import java.util.Scanner;
public class AddMultiplePerson {
	String province[]= {"河北省","山东省","辽宁省","黑龙江省","甘肃省","吉林省","青海省","河南省","江苏省","湖北省","湖南省","浙江省","江西省","广东省","云南省","福建省","台湾省","海南省","山西省","四川省","陕西省","贵州省","安徽省","北京市","重庆省","广西壮族自治区","内蒙古自治区","宁夏回族自治区","上海市","天津市","西藏自治区","新疆维吾尔自治区"};
	Scanner reader = new Scanner(System.in);
	int MAX = 1000;
	int m_Size=0;
	int time; // 记录最终用户数量
	Person persons[] = new Person[MAX];
	
	// 随机生成地址
	String Province() { 
		int s = new Random().nextInt(province.length);
		int c;
		int time; // 生成用户的数量
		String site=" ";
		switch (s){
			case 0:			
				String hebei[] = {"保定市","沧州市","承德市","邯郸市","衡水市","廊坊市","秦皇岛市","石家庄市","唐山市","邢台市","张家口市"};
				c = new Random().nextInt(hebei.length);
				site="河北省"+hebei[c];
				break;
			case 1:			
				String shandong[] = {"滨州市","德州市","东营市","菏泽市","济南市","济宁市","聊城市","临沂市","青岛市","日照市","泰安市","潍坊市","威海市","烟台市","枣庄市","淄博市"};
				c = new Random().nextInt(shandong.length);
				site="山东省"+shandong[c];
				break;
			case 2:			
				String city[] = {"鞍山市","本溪市","朝阳市","大连市","丹东市","抚顺市","阜新市","葫芦岛市","锦州市","辽阳市","盘锦市","沈阳市","铁岭市","营口市"};
				c = new Random().nextInt(city.length);
				site="辽宁省"+city[c];
				break;
			case 3:			
				String heilongjiang[] = {"大庆市","大兴安岭地区","哈尔滨市","鹤岗市","黑河市","鸡西市","佳木斯市","牡丹江市","齐齐哈尔市","七台河市","双鸭山市","绥化市","伊春市"};
				c = new Random().nextInt(heilongjiang.length);
				site="黑龙江省"+heilongjiang[c];
				break;
			case 4:			
				String gansu[] = {"白银市", "定西市", "甘南藏族自治州","嘉峪关市", "金昌市", "酒泉市","兰州市", "临夏回族自治州", "陇南市", "平凉市", "庆阳市", "天水市","武威市", "张掖市"};
				c = new Random().nextInt(gansu.length);
				site="甘肃省"+gansu[c];
				break;
			case 5:			
				String jilin[] = {"白城市","白山市","长春市","吉林市","辽源市","四平市","松原市","通化市","延边朝鲜族自治州"};
				c = new Random().nextInt(jilin.length);
				site="吉林省"+jilin[c];
				break;
			case 6:			
				String qinghai[] = {"果洛藏族自治州","海北藏族自治州","海东市","海南藏族自治州","海西蒙古族藏族自治州","黄南藏族自治州","西宁市","玉树藏族自治州"};
				c = new Random().nextInt(qinghai.length);
				site="青海省"+qinghai[c];
				break;
			case 7:			
				String henan[] = {"安阳市","鹤壁市","济源市","焦作市","开封市","漯河市","洛阳市","南阳市","平顶山市","濮阳市","三门峡市","商丘市","新乡市","信阳市","许昌市","郑州市","周口市","驻马店市"};
				c = new Random().nextInt(henan.length);
				site="河南省"+henan[c];
				break;
			case 8:			
				String jiangsu[] = {"常州市","淮安市","连云港市","南京市","南通市","宿迁市","苏州市","秦州市","无锡市","徐州市","盐城市","扬州市","镇江市"};
				c = new Random().nextInt(jiangsu.length);
				site="江苏省"+jiangsu[c];
				break;
			case 9:			
				String hubei[] = {"鄂州市", "恩施土家族苗族自治州", "黄冈市", "黄石市", "荆门市" ,"潜江市", "神农架林区", "十堰市", "随州市", "天门市", "武汉市", "咸宁市", "仙桃市", "襄阳市", "孝感市", "宜昌市"};
				c = new Random().nextInt(hubei.length);
				site="湖北省"+hubei[c];
				break;
			case 10:			
				String hunan[] = {"邵阳市","常德市","长沙市","郴州市","衡阳市","怀化市","娄底市","湘潭市","湘西土家族苗族自治州","益阳市","永州市","岳阳市","张家界市","株洲市"};
				c = new Random().nextInt(hunan.length);
				site="湖南省"+hunan[c];
				break;
			case 11:			
				String zhejiang[] = {"杭州市","湖州市","嘉兴市","金华市","丽水市","宁波市","衢州市","绍兴市","台州市","温州市","舟山市"};
				c = new Random().nextInt(zhejiang.length);
				site="浙江省"+zhejiang[c];
				break;
			case 12:			
				String jiangxi[] = {"抚州市","赣州市","吉安市","景德镇市","九江市","南昌市","萍乡市","上饶市","新余市","宜春市","鹰潭市"};
				c = new Random().nextInt(jiangxi.length);
				site="江西省"+jiangxi[c];
				break;
			case 13:			
				String guangdong[] = {"潮州市","东莞市","东沙群岛","佛山市","广州市","河源市","惠州市","江门市","揭阳市","茂名市","梅州市","清远市","汕头市","汕尾市","韶关市","深圳市","阳江市","云浮市","湛江市","肇庆市","中山市","珠海市"};
				c = new Random().nextInt(guangdong.length);
				site="广东省"+guangdong[c];
				break;
			case 14:			
				String yunnan[] = {"保山市","楚雄彝族自治州","大理白族自治州","德宏傣族景颇族自治州","迪庆藏族自治州","红河哈尼族彝族自治州","昆明市","丽江市","临沧市","怒江傈僳族自治州","普洱市","曲靖市","文山壮族苗族自治州","西双版纳傣族自治州","玉溪市","昭通市"};
				c = new Random().nextInt(yunnan.length);
				site="云南省"+yunnan[c];
				break;
			case 15:			
				String fujian[] = {"福州市","龙岩市","南平市","宁德市","莆田市","泉州市","三明市","厦门市","漳州市"};
				c = new Random().nextInt(fujian.length);
				site="福建省"+fujian[c];
				break;
			case 16:			
				String taiwan[] = {"台北市","高雄市"};
				c = new Random().nextInt(taiwan.length);
				site="台湾省"+taiwan[c];
				break;
			case 17:			
				String hainan[] = {"白沙黎族自治县","保亭黎族苗族自治县","昌江黎族自治县","澄迈县","儋州市","定安县","东方市","海口市","乐东黎族自治县","临高县","陵水黎族自治县","琼海市","琼中黎族苗族自治县","三沙市","三亚市","屯昌县","万宁市","文昌市","五指山市"};
				c = new Random().nextInt(hainan.length);
				site="海南省"+hainan[c];
				break;
			case 18:			
				String shanxi[] = {"长治市","大同市","晋城市","晋中市","临汾市","吕梁市","朔州市","太原市","忻州市","阳泉市","运城市"};
				c = new Random().nextInt(shanxi.length);
				site="山西省"+shanxi[c];
				break;
			case 19:			
				String sichuan[] = {"阿坝藏族羌族自治州","巴中市","成都市","达州市","德阳市","甘孜藏族自治州","广安市","广元市","乐山市","凉山彝族自治州","泸州市","眉山市","绵阳市","南充市","内江市","攀枝花市","遂宁市","雅安市","宜宾市","自贡市","资阳市"};
				c = new Random().nextInt(sichuan.length);
				site="四川省"+sichuan[c];
				break;
			case 20:			
				String Shanxi[] = {"安康市","宝鸡市","汉中市","商洛市","铜川市","渭南市","西安市","咸阳市","延安市","榆林市"};
				c = new Random().nextInt(Shanxi.length);
				site="陕西省"+Shanxi[c];
				break;
			case 21:			
				String guizhou[] = {"安顺市","毕节市","贵阳市","六盘水市","黔东南苗族侗族自治州","黔南布衣族苗族自治州","黔西南布衣族苗族自治州","铜仁市","遵义市"};
				c = new Random().nextInt(guizhou.length);
				site="贵州省"+guizhou[c];
				break;
			case 22:			
				String anhui[] = {"安庆市","蚌埠市","亳州市","池州市","滁州市","阜阳市","合肥市","淮北市","淮南市","黄山市","六安市","马鞍山市","宿州市","铜陵市","芜湖市","宣城市"};
				c = new Random().nextInt(anhui.length);
				site="安徽省"+anhui[c];
				break;
			case 23:			
				String beijing[] = {"昌平区", "朝阳区", "大兴区", "东城区", "房山区", "丰台区", "海淀区", "怀柔区", "门头沟区", "密云区", "平谷区", "石景山区", "顺义区", "通州区", "西城区", "延庆区"};
				c = new Random().nextInt(beijing.length);
				site="北京市"+beijing[c];
				break;
			case 24:			
				String chongqing[] = {"巴南区", "北碚区", "璧山区", "长寿区" ,"城口县", "大渡口区", "大足区", "垫江县", "丰都县", "奉节县", "涪陵区", "合川区", "江北区", "江津区", "九龙坡区", "开州区", "梁平区", "南岸区", "南川区", "彭水苗族土家族自治县", "綦江区", "黔江区", "荣昌区", "沙坪坝区", "石柱土家族自治县", "铜梁区", "潼南区", "万州区", "武隆区", "巫山县", "巫溪县", "秀山土家族苗族自治县", "永川区", "酉阳土家族苗族自治县", "渝北区", "渝中区", "云阳县" ,"忠县"};
				c = new Random().nextInt(chongqing.length);
				site="重庆市"+chongqing[c];
				break;
			case 25:			
				String guangxi[] = {"百色市", "北海市", "崇左市", "防城港市", "贵港市", "桂林市", "河池市", "贺州市", "来宾市", "柳州市", "南宁市", "钦州市", "梧州市", "玉林市"};
				c = new Random().nextInt(guangxi.length);
				site="广西壮族自治区"+guangxi[c];
				break;
			case 26:			
				String neimeng[] = {"阿拉善盟", "巴彦淖尔市", "包头市", "赤峰市", "鄂尔多斯市", "呼和浩特市", "呼伦贝尔市", "通辽市", "乌海市", "乌兰察布市", "锡林郭勒盟", "兴安盟"};
				c = new Random().nextInt(neimeng.length);
				site="内蒙古自治区"+neimeng[c];
				break;
			case 27:			
				String ningxia[] = {"固原市", "石嘴山市", "吴忠市", "银川市","中卫市"};
				c = new Random().nextInt(ningxia.length);
				site="宁夏回族自治区"+ningxia[c];
				break;
			case 28:			
				String shanghai[] = {"宝山区", "长宁区", "崇明区", "奉贤区", "虹口区", "黄浦区", "嘉定区", "金山区", "静安区", "闵行区", "浦东新区", "普陀区", "青浦区", "松江区", "徐汇区", "杨浦区"};
				c = new Random().nextInt(shanghai.length);
				site="上海市"+shanghai[c];
				break;
			case 29:			
				String tianjin[] = {"宝坻区","北辰区", "滨海新区", "东丽区", "河北区", "河东区", "和平区","河西区", "红桥区", "蓟州区", "津南区", "静海区","南开区","宁河区", "武清区", "西青区"};
				c = new Random().nextInt(tianjin.length);
				site="天津市"+tianjin[c];
				break;
			case 30:			
				String xizang[] = {"阿里地区", "昌都市", "拉萨市", "林芝市", "那曲市", "日喀则市", "山南市"};
				c = new Random().nextInt(xizang.length);
				site="西藏自治区"+xizang[c];
				break;
			case 31:			
				String xinjiang[] = {"阿克苏地区", "阿拉尔市", "阿勒泰地区", "巴音郭楞蒙古自治州", "北屯市", "博尔塔拉蒙古自治州", "昌吉回族自治州", "哈密市", "和田地区", "喀什地区", "可克达拉市", "克拉玛依市", "克孜勒苏柯尔克孜自治州", "昆玉市", "石河子市", "双河市","塔城地区", "铁门关市", "吐鲁番市", "图木舒克市", "五家渠市","乌鲁木齐市", "伊犁哈萨克自治州"};
				c = new Random().nextInt(xinjiang.length);
				site="新疆维吾尔自治区"+xinjiang[c];
				break;
		}
		return site;
	}
	
	// 随机生成姓和名
	String Name() {
		String Familyname[] = {"欧阳","上官","皇甫","令狐","诸葛","司徒","申屠","夏侯","贺兰","完颜","慕容","尉迟","长孙","王","李","张","刘","陈","杨","黄","赵","吴","周","徐","孙","马","朱","胡","郭","何","林","罗","高","郑","梁","谢","宋","唐","许","韩","邓",
								"冯","曹","彭","曾","肖","田","董","潘","袁","蔡","蒋","余","于","杜","叶","程","魏","苏","吕","丁","任","卢","姚","沈","钟","姜","崔","谭","陆","范","汪","廖","石","金","韦","贾","夏","付","方","邹","熊","白","孟","邱","侯","江","尹",
								"薛","舒","闫","段","雷","龙","黎","史","陶","贺","毛","郝","顾","龚","邵","万","覃","武","钱","戴","严","莫","孔","向","常"};
		int x = new Random().nextInt(Familyname.length);
		String Givenname[] = {"吉惟","国瑞","玟书","南","奕云","柏宏","建安","子帆","志豪","茹定","中冰","文隆","彦文","智翔","振霞","姿婷","姿康","致盈","一强","芸贵","伊雯","进宝","美隆","心真","美珠","芳天","雅惠","文婷","敏侑","依婷","婉璇","美玉","依婷","昌梦",
							"家纶","丽昆","育泉","芸欢","韵如","肇芬","木仲","成白","兆玉","翊惠","汉臻","佳瑞","绿珮","白芷","姿妤","虹伦","琼玟","怡芳","贵妃","佩芳","文旺","盛玫","丽青","智云","孟涵","小爱","恩龙","政廷","诗涵","政倩","俊伯","馨学","惠珠","思翰","佩","海来",
							"翊","建智","淑芬","雅琪","怡宜","育霖","仪湖","俊民","诗刚","虹荣","美玲","仪琳","俞幸","秋萍","吉维","佩珊","必辰","媚拉","永康","耀华","郁婷","秀玲","佳","好","帅","蕊"};
		int m = new Random().nextInt(Givenname.length);
		return Familyname[x]+Givenname[m];
	}
	
	// 随机生成电话号码，并区别移动、联通、电信
	String Num() {
		String num [] = {"133","149","153","173","177","180","181","189","130","131","132","145","155","156","166","175","176","185","186","134","135","136","137","138","139","147","150","151","152","157","158","159","178","182","183","184","187","188"};
		String one = num[new Random().nextInt(num.length)];
		String four = String.valueOf(new Random().nextInt(10));
		String five = String.valueOf(new Random().nextInt(10));
		String six = String.valueOf(new Random().nextInt(10));
		String seven = String.valueOf(new Random().nextInt(10));
		String eight = String.valueOf(new Random().nextInt(10));
		String nine = String.valueOf(new Random().nextInt(10));
		String ten = String.valueOf(new Random().nextInt(10));
		String eleven = String.valueOf(new Random().nextInt(10));
		return one+four+five+six+seven+eight+nine+ten+eleven;
	}
	
	// 随机生成联系人的性别
	String Sex() {
		String sex[] = {"男","女"};
		int s = new Random().nextInt(2);
		return sex[s];
	}
	
	// 呈现用户所要生成的用户
	void view () {
		String t_name;
		String t_sex;
		String t_phone;
		String t_addr;
		String province;
		System.out.println("请输入你要生成的用户数量：");
		time = reader.nextInt();
		while (time<=0) {
			System.out.println("生成的用户数量不能少于1个，请重新输入。");
			time = reader.nextInt();
		}
		AddMultiplePerson addmultipleperson = new AddMultiplePerson();
		Phonenumber phonenumber = new Phonenumber();
		Person person = new Person();
		for(int i = 0;i<time; i++) {
			t_name = addmultipleperson.Name();
			t_sex = addmultipleperson.Sex();
			t_phone = addmultipleperson.Num();
			t_phone = phonenumber.PhoneNumber(t_phone)+'-'+t_phone;
			t_addr = addmultipleperson.Province();
			person.m_name = t_name;
			person.m_Sex = t_sex;
			person.m_phone = t_phone;
			person.m_Addr = t_addr;
			System.out.print("姓名："+t_name+'\t');
			System.out.print("性别："+t_sex+'\t');
			System.out.print("电话："+t_phone+'\t'+'\t');
			System.out.println("住址："+t_addr);
			persons[i] = person; 
		}
	}
}
