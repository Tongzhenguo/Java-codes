/*
package udf;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.util.ArrayList;

*/
/**
 * Created by arachis on 2017/10/19.
 * 一个简单的UDF:
 * 解析json array中的指定字段，并用下划线拼接起来
 *//*

public class MyUDF extends UDF {
    */
/**
     * 把json array字符串中指定的字段解析出来
     *
     * @param jsonArrayStr 　要解析的json array字符串
     * @param column       　要提取的字段
     * @return str
     * <p/>
     * hive example:
     * hive>select *,parse_json_array(get_json_object('{"data":[{"id":1082},{"id":1082},{"id":1082}]}','$.data'),'id') from dual;
     * hive>+-----------+-----------------+--+
     * | dual.foo  |       _c1       |
     * +-----------+-----------------+--+
     * | NULL      | 1082_1082_1082  |
     * +-----------+-----------------+--+
     *//*

    public String evaluate(String jsonArrayStr, String column) {
        if ((jsonArrayStr == null) || StringUtils.isBlank(jsonArrayStr) || !jsonArrayStr.trim().startsWith("[")) {
            return null;
        }
        JSONArray jsonArray = null;
        ArrayList<String> tag_ids = new ArrayList<String>();
        try {
            jsonArray = new JSONArray(new JSONTokener(jsonArrayStr));
            for (int i = 0; i < jsonArray.length(); i++) {
                String json = jsonArray.getJSONObject(i).get(column).toString();
                tag_ids.add(json);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return StringUtils.join(tag_ids, '_');
    }

    public static void main(String[] args) {
        String jas = "[{\"id\":1082},{\"id\":1082},{\"id\":1082}]";
        System.out.println(new MyUDF().evaluate(jas, "id"));

    }

}*/
