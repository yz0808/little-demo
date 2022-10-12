package com.little.demo.set;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author yangzhong
 * @Date 2022-01-05 15:23
 * @Description 描述
 */
public class SetContainsTest {
    public static void main(String[] args) {
        String str = "zhangfei5,15032271623_p,18736887798_p,18901158812_p,7freshmt980,7freshmt981,7ftestnew304,7ftestnew305,7ftestnew306,7ftestnew307,7ftestnew328,7ftestnew515,7test1,7test30,993997860,JD_0x135378bc7,JD_223106f7910b716,Jean881228,a295172567,chenguangzheng1993,douhaipeng,gxzpyboa,huangmiao03,jd_40574b0ce9296,jd_40628f26684ec,jd_4dbde33131ab3,jd_565a870014051,jd_567e8c857b815,jd_599f039e63416,jd_5d6c85f7ebf25,jd_62608cd5f38fc,jd_62b43da93dcbb,jd_646d434203038,jd_6ada1c7e023ba,jd_6d6f755669e75,jd_709b1caf31a48,jd_785f844089cb1,jd_7b42948118bc0,jd_ibreDCMFuhkp,jd_inROiaGAvwgZ,jd_xqRtopPuGOcE,jiesuantest14,jiesuantest17,jiesuantest18,jinhan_135,wangminxiaobai002,wangminxiaobai003,wangminxiaobai004,wosicjl,wowuliao105,zhaonahx,zonghetest,张Qq-_,快乐自来疯,曾先生(先生),紫日东来00,蓝色的眼泪wxj,蓝藤叶,jd_709b1caf31a48,jd_ibreDCMFuhkp,jd_6d6f755669e75,jd_62b43da93dcbb,张Qq-_,7freshmt98,trade2018,琴月吹雪,明朝那些事1566,jd_49a3e8bec5ec9,宏圣元,yjpz测试056,yjpz测试057,jadl,chenpu0811,jd_62e427997833c,jd_40e2201e2a0b6,jd_6fd71ffff45a7,7ftestnew304,7ftestnew305,7ftestnew306,7ftestnew307,jd_40628f26684ec,18901158812_p,7ftestnew014,7testnew359,jd_6d4e7ba93dbf3,7testnew356,7testnew357,7testnew358,7testnew360,testlijie666,lijie84";
        Set<String> sets = new HashSet<>(Arrays.asList(str.split(",")));
        System.out.println(JSON.toJSONString(sets));
        System.out.println(sets.contains("wangminxiaobai004"));
    }
}
