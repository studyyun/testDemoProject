package com.example.test;


import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
import com.example.demo.bean.Sysuser;
import com.example.test.bean.EmailAllReceiver;
import com.example.test.bean.MultiMt;
import com.example.test.bean.Receiver;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-02  10:16
 */
@Slf4j
public class TestJson {

    public static void main(String[] args) {

        /*List<String> list = new ArrayList<String>(){{
            add("111");
            add("222");
            add("333");
        }};
        System.out.println(JSONObject.toJSONString(list));*/

//        testJson1();
//        testJson2();
//        testJson3();
//        testJson4();
        System.out.println(Objects.equals(null, 1));
        System.out.println(Objects.equals(1, null));
        System.out.println(Objects.equals(null, null));
        System.out.println(Objects.equals(1, 1));
    }

    private static void testJson4() {
        cn.hutool.json.JSONObject permission = getParamObj("", "", "");
        cn.hutool.json.JSONArray childs = JSONUtil.createArray();

        cn.hutool.json.JSONObject obj1 = getParamObj("P1", "=", "admin");
        obj1.put("bindMode", "or");
        childs.add(obj1);

        // RPT_RVOK_CREATETIME 这个字段为空则表明 UM_RPT_RVOK 没有这条记录
        cn.hutool.json.JSONObject obj2 = getParamObj("P2", "in", "1231231245");
        obj2.put("bindMode", "or");
        childs.add(obj2);

        permission.put("childs", childs);
        cn.hutool.json.JSONArray array = JSONUtil.createArray();
        array.add(permission);

        System.out.println(array.toString());
    }

    private static cn.hutool.json.JSONObject getParamObj(String fieldName, String matcher, Object fieldValue) {
        return getParamObj(fieldName, matcher, fieldValue, "string", false);
    }

    private static cn.hutool.json.JSONObject getParamObj(String fieldName, String matcher, Object fieldValue, String fieldValueType) {
        return getParamObj(fieldName, matcher, fieldValue, fieldValueType, false);
    }

    private static cn.hutool.json.JSONObject getParamObj(String fieldName, String matcher, Object fieldValue, String fieldValueType, boolean date) {
        cn.hutool.json.JSONObject param = JSONUtil.createObj();
        param.put("fieldName", fieldName);
        param.put("matcher", matcher);
        param.put("fieldValue", fieldValue);
        param.put("fieldUseMode", "filter");
        param.put("bindMode", "and");
        param.put("fieldValueType", fieldValueType);
        if (date){
            param.put("fieldUseMode", "filterAndIndexNameSuffix");
            param.put("fieldValueType", "date");
            param.put("fieldValueFormat", "yyyy-MM-dd HH:mm:ss");
        }
        return param;
    }

    private static void testJson3() {

        List<MultiMt> list = new ArrayList<>();
        MultiMt mt = new MultiMt();
        Receiver receiver = new Receiver();
        receiver.setEmail("231312@qq.com");
        receiver.setMobile("13548546666");
        receiver.setRcvMsgId(123124132131651651L);
        receiver.setWechat(new HashMap<>());
        List<Receiver> receivers = new ArrayList<Receiver>(){{add(receiver);}};
        mt.setReceiver(receivers);
        mt.setContent("dqweqweqw");
        mt.setTitle("主题");
        list.add(mt);

        String[] excludeProperties = {"mobile", "wechat", "rcvMsgId"};
        String[] includeProperties = {"id", "username", "mobile"};
        PropertyPreFilters filters = new PropertyPreFilters();
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(excludeProperties);
        PropertyPreFilters.MySimplePropertyPreFilter includefilter = filters.addFilter();
        includefilter.addIncludes(includeProperties);

        System.out.println(JSONObject.toJSONString(list) + "\r\n");
        System.out.println(JSONObject.toJSONString(list, excludefilter) + "\r\n");



        /*PropertyFilter profilter = new PropertyFilter() {
         @Override
         public boolean apply(Object object, String name, Object value) {
                     if (name.equals("email")) {
                             // false表示字段将被排除在外
                         System.out.println(name);
                         name = "邮件名";
                             return true;
                         }
                     return true;
                 }
        };
        System.out.println(JSONObject.toJSONString(list, profilter));*/

        ValueFilter valueFilter = new ValueFilter() {
            @Override
            public Object process(Object o, String propertyName, Object propertyValue) {
                if(propertyName.equals("receiver")){
                    return "收件人";    //返回修改后的属性值对象
                }

                return propertyValue;
            }
        };

        String jsonString = JSON.toJSONString(list, valueFilter);
        System.out.println("jsonString is: " + jsonString);

    }

    private static void testJson2() {
        /*List<String> list1  = new ArrayList<String>(){{
            add("111");
            add("222");
            add("333");
        }};
        String jsonString = JSONObject.toJSONString(list1);
        System.out.println(jsonString);

        String s = JSONArray.toJSONString(list1);
        System.out.println(s);
        List<String> list = JSONArray.parseArray(s, String.class);
        int i = 0;*/

        String s = JSONArray.toJSONString(null);
        System.out.println(s);
        ArrayList<String> arrayList = new ArrayList<String>() {{
            add("");
            add("3212 3232");
        }};
        String s1 = JSONArray.toJSONString(arrayList);
        System.out.println(s1);

        System.out.println(JSONObject.toJSONString(null));

        List<String> list = JSONArray.parseArray(s, String.class);
        List<String> list1 = JSONArray.parseArray(s1, String.class);
        int i = 0;

        String a = null;
        List<String> list2 = JSONArray.parseArray(a, String.class);
        int i2 = 2;
    }

    private static void testJson1() {
        EmailAllReceiver emailAllReceiver = new EmailAllReceiver();
        System.out.println(JSONObject.toJSONString(emailAllReceiver));
        emailAllReceiver.setReceiverList(Arrays.asList("1111@qq.com","1111@qq.com"));
        emailAllReceiver.setCcReceiverList(null);
        emailAllReceiver.setBCcReceiverList(Arrays.asList(";".split(",")));
        String s = JSONObject.toJSONString(emailAllReceiver);
        System.out.println(s);
        EmailAllReceiver allReceiver = JSONObject.parseObject(s, EmailAllReceiver.class);
        int i = 0;

        String a = ";";
        a = StringEscapeUtils.unescapeHtml(a);
        List<String> list = Arrays.asList(a.split(";"));
        int j = 0;
    }

}
