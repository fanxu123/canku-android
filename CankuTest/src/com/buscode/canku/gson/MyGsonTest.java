package com.buscode.canku.gson;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MyGsonTest {

    @GsonBean
    static class JsonWithGsonBean {
        public String name;
    }
    static class JsonWithoutGsonBean {
        public String name;
    }
    // {"name":"JsonWithGsonBean"}
    @Test
    public void testFromJsonWithGsonBean() throws Exception {
        MyGson myGson = new MyGson();
        String json_string = "{\"name\":\"JsonWithGsonBean\"}";
        JsonWithGsonBean j1 =  myGson.fromJson(json_string, JsonWithGsonBean.class);
        Assert.assertEquals(j1.name, "JsonWithGsonBean");
        System.out.println("测试通过: MyGsonTest.FromJsonWithGsonBean");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromJsonWithoutGsonBean() throws Exception {
        MyGson myGson = new MyGson();
        String json_string = "{\"name\":\"JsonWithGsonBean\"}";
        JsonWithoutGsonBean j1 =  myGson.fromJson(json_string, JsonWithoutGsonBean.class);
        System.out.println("测试失败: MyGsonTest.FromJsonWithoutGsonBean");
    }

    @Test
    public void testToJsonWithGsonBean() throws Exception {

        MyGson gson = new MyGson();
        JsonWithGsonBean bean = new JsonWithGsonBean();
        bean.name = "JsonWithGsonBean";
        String result = gson.toJson(bean);
        Assert.assertTrue(result.contains(bean.name));
        System.out.println("测试通过: MyGsonTest.ToJsonWithGsonBean");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToJsonWithoutGsnBean() throws Exception {

        MyGson gson = new MyGson();
        JsonWithoutGsonBean bean = new JsonWithoutGsonBean();
        bean.name = "JsonWithGsonBean";
        String result = gson.toJson(bean);
        System.out.println("测试失败: MyGsonTest.ToJsonWithoutGsnBean");
    }

}
