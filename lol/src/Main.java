import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Main {
    private static final String[] places = {
            "top","mid","jug","adc","sup"
    };
    private static final String[] heroes = {
            "黑暗之女", "狂战士", "正义巨像", "卡牌大师", "德邦总管", "无畏战车", "诡术妖姬", "猩红收割者",
            "远古恐惧", "正义天使", "无极剑圣", "牛头酋长", "符文法师", "亡灵战神", "战争女神", "众星之子",
            "迅捷斥候", "麦林炮手", "祖安怒兽", "雪原双子", "赏金猎人", "寒冰射手", "蛮族之王", "武器大师",
            "堕落天使", "时光守护者", "炼金术士", "痛苦之拥", "瘟疫之源", "死亡颂唱者", "虚空恐惧", "殇之木乃伊",
            "披甲龙龟", "冰晶凤凰", "恶魔小丑", "祖安狂人", "琴瑟仙女", "虚空行者", "刀锋舞者", "风暴之怒",
            "海洋之灾", "英勇投弹手", "天启者", "瓦洛兰之盾", "邪恶小法师", "巨魔之王", "诺克萨斯统领", "皮城女警",
            "蒸汽机器人", "熔岩巨兽", "不祥之刃", "永恒梦魇", "扭曲树精", "荒漠屠夫", "德玛西亚皇子", "蜘蛛女皇",
            "发条魔灵", "齐天大圣", "复仇焰魂", "盲僧", "暗夜猎手", "机械公敌", "魔蛇之拥", "上古领主",
            "大发明家", "沙漠死神", "狂野女猎手", "兽灵行者", "圣锤之毅", "酒桶", "不屈之枪", "探险家",
            "铁铠冥魂", "牧魂人", "离群之刺", "狂暴之心", "德玛西亚之力", "曙光女神", "虚空先知", "刀锋之影",
            "放逐之刃", "深渊巨口", "暮光之眼", "光辉女郎", "远古巫灵", "龙血武姬", "九尾妖狐", "法外狂徒",
            "潮汐海灵", "不灭狂雷", "傲之追猎者", "惩戒之箭", "深海泰坦", "机械先驱", "北地之怒", "无双剑姬",
            "爆破鬼才", "仙灵女巫", "荣耀行刑官", "战争之影", "虚空掠夺者", "诺克萨斯之手", "未来守护者",
            "冰霜女巫", "皎月女神", "德玛西亚之翼", "暗黑元首", "铸星龙王", "影流之镰", "暮光星灵", "荆棘之兴",
            "虚空之女", "星籁歌姬", "迷失之牙", "生化魔人", "疾风剑豪", "虚空之眼", "岩雀", "青钢影",
            "影哨", "虚空女皇", "弗雷尔卓德之心", "戏命师", "永猎双子", "祖安花火", "暴走萝莉", "河流之王",
            "狂厄蔷薇", "破败之王", "涤魂圣枪", "圣枪游侠", "影流之主", "暴怒骑士", "时间刺客", "元素女皇",
            "皮城执法官", "暗裔剑魔", "唤潮鲛姬", "沙漠皇帝", "魔法猫咪", "沙漠玫瑰", "魂锁典狱长", "海兽祭司",
            "虚空遁地兽", "翠神", "复仇之矛", "星界游神", "幻翎", "逆羽", "山隐之焰", "解脱者", "万花通灵",
            "残月之肃", "镕铁少女", "血港鬼影", "愁云使者", "封魔剑魂", "腕豪", "含羞蓓蕾", "灵罗娃娃",
            "炼金男爵", "不羁之悦", "纳祖芒荣耀", "炽炎雏龙", "明烛", "异画师", "百裂冥犬"
    };
    private static final String[] talents= {"强攻","致命节奏","迅捷步伐","征服者","电刑","丛刃"," 黑暗收割",
            " 掠食者"," 艾黎","彗星"," 相位猛冲","余震"," 守护者","不灭之握","启封秘籍","冰川增幅"};
    private static final String[] skills= {"闪现","点燃","传送","惩戒","治疗","屏障"," 虚弱", "净化"," 疾跑"};
    private static final String[] items = {
            "梅贾的窃魂卷", "基克的聚合", "莫雷洛秘典", "舒瑞娅的战歌", "海力亚的回响", "月石再生器",
            "骑士之誓", "钢铁烈阳之匣", "冰霜之心", "帝国指令", "炽热香炉", "流水法杖", "救赎", "米凯尔的祝福",
            "凛冬之临", "深渊面具", "引路者", "海克斯科技火箭腰带", "巨蛇之牙", "厌恨锁链", "时光之杖", "瑞莱的冰晶节杖",
            "黯影阔剑", "冰脉护手", "视界专注", "黎明核心", "幽梦之灵", "禁忌时机", "荆棘之甲", "兰顿之兆",
            "日炎圣盾", "残疫", "夜之锋刃", "卢安娜的飓风", "幻影之舞", "智慧末刃", "星蚀", "玛莫提乌斯之噬",
            "炼金朋克链锯剑", "无终恨意", "自然之力", "璀璨回响", "蜕生", "魔宗", "风暴狂涌", "感电三轮刃",
            "振奋盔甲", "败魔", "亡者的板甲", "卢登的伙伴", "大天使之杖", "纳什之牙", "兰德里的折磨", "星界驱驰",
            "裂隙制造者", "虚空之杖", "鬼索的狂暴之刃", "狂妄", "公理圆弧", "收集者", "海妖杀手", "斯塔缇克电刃",
            "疾射火炮", "夺萃之镰", "不朽盾弓", "水银弯刀", "凡性的提醒", "米尼克领主的致意", "界弓", "海克斯注力刚壁",
            "破舰者", "黑色切割者", "心之钢", "斯特拉克的挑战护手", "女妖面纱", "巫妖之祸", "岚切", "挺进破坏者",
            "朔极之矛", "焚天", "狂徒铠甲", "影焰", "赛瑞尔达的怨恨", "破败王者之刃", "死亡之舞", "守护天使",
            "千变者贾修", "中娅沙漏", "无尽之刃", "纳沃利迅刃", "贪欲九头蛇", "巨型九头蛇", "三相之力", "亵渎九头蛇",
            "饮血剑", "灭世者的死亡之帽"
    };


    public static void main(String[] args) {
        final int   NUMBER_OF_TEAM  = 5;//
            Random random = new Random();
        for (int j = 0; j <= 1; j++) {//几个队伍

            int []indexOfPlaces =new int[5];//位置索引
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i <= NUMBER_OF_TEAM-1; i++) {
                numbers.add(i);
            }
            Collections.shuffle(numbers);
            for (int i = 0; i <=NUMBER_OF_TEAM-1; i++) {
                indexOfPlaces [i]= numbers.get(i);
            }//每队五个位置，位置随机排列
            numbers.clear();

            int []indexOfHeroes =new int[5];//英雄索引
            for (int i = 0; i <=NUMBER_OF_TEAM-1; i++) {
                int temp = random.nextInt(heroes.length);
                if (!numbers.contains(temp))
                    numbers.add (random.nextInt(heroes.length));//在heroes字符串数组中随机抽取一个不相同的索引
            }
            Collections.shuffle(numbers);//打乱随机排序
            for (int i = 0; i <= numbers.size()-1; i++) {
                indexOfHeroes[i]= numbers.get(i);//赋值给索引
            }
            numbers.clear();

            for (int i = 0; i <= NUMBER_OF_TEAM-1; i++) {


                int []indexOfSkills =new int[2];//技能索引

                indexOfSkills[0] = random.nextInt(skills.length);
                if(indexOfPlaces[i]==2){
                    indexOfSkills[0]  =3;
                }

                indexOfSkills[1] = random.nextInt(skills.length);
                if(indexOfSkills[0]==indexOfSkills[1]){
                    indexOfSkills[1]=(indexOfSkills[1]+1)%skills.length;
                }

                System.out.println((i+j*5) + "号的选择是：" +
                        places[indexOfPlaces [i]] + "  "
                        + heroes[indexOfHeroes[i]] + "  "
                        + talents[ random.nextInt(talents.length)] + "  "
                        + skills[indexOfSkills[1]] + "  " +skills[indexOfSkills[0]]+" "
                        + items[random.nextInt(items.length)]);

            }
        }
    }
}