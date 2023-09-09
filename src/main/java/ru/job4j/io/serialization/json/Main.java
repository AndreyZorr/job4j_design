package ru.job4j.io.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.job4j.io.serialization.xml.Number;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject("{\"number\":\"111\"}");
        List<String> list = new ArrayList<>();
        list.add("number");
        JSONArray jsonArray = new JSONArray(list);

        final Car car = new Car(false, 70, new Number("111"), "Sacha, Vika");
        JSONObject object = new JSONObject();
        object.put("v8", car.isV8());
        object.put("age", car.getAge());
        object.put("number", jsonObject);
        object.put("ownerses", jsonArray);
        System.out.println(object.toString());
        System.out.println(new JSONObject().toString());
    }
}