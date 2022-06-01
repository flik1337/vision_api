package cn.flik1337.vision.common.utils;

import cn.flik1337.vision.vo.CinemaPriceVo;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class MapUtil {
    public static Map<Integer,Integer> transToMap(List<CinemaPriceVo> priceList){

        if (priceList.size() > 0){

            Map<Integer, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < priceList.size(); i++) {
                CinemaPriceVo cinemaPriceVo = priceList.get(i);
                Integer cinemaId = cinemaPriceVo.getCinemaId();
                Integer price = cinemaPriceVo.getPrice();
                map.put(cinemaId,price);

            }
            return map;
        }
        return null;
    }
//    public static Map<Integer,Integer> transToMap(List<HashMap<Integer,Integer>> priceList){
//        // priceList = [{price=1990, cinemaId=11}, {price=1990, cinemaId=13}, {price=3990, cinemaId=12}]
//        if (priceList.size() > 0){
//
//            Map<Integer, Integer> map = new LinkedHashMap<>();
//            for (int i = 0; i < priceList.size(); i++) {
//                //CinemaPriceVo cinemaPriceVo = priceList.get(i);
//                HashMap<Integer,Integer> hash = priceList.get(i);
//                Object[] values = hash.values().toArray();
//                System.out.println(values[0].toString());
//                System.out.println(values[1].toString());
//                map.put(Integer.parseInt(values[1].toString()),Integer.parseInt(values[0].toString()));
////                Integer key  = keys[0];
////                System.out.println(key);
////                CinemaPriceVo cinemaPriceVo = new CinemaPriceVo();
////                cinemaPriceVo.setCinemaId(key);
////                cinemaPriceVo.setCinemaId(hash.get(key));
////
////                map.put(cinemaPriceVo.getCinemaId(),cinemaPriceVo.getPrice());
//            }
//            return map;
//        }
//        return null;
//    }
    //double newPrice = new BigDecimal(cinemaPriceVo.getPrice()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
}
