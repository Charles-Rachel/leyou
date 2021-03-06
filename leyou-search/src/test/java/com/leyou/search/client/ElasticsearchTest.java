//package com.leyou.search.client;
//
//import com.leyou.common.pojo.PageResult;
//import com.leyou.item.pojo.Spu;
//import com.leyou.item.pojo.SpuBo;
//import com.leyou.search.LeyouSearchApplication;
//import com.leyou.search.bean.Goods;
//import com.leyou.search.reponsitory.GoodsRepository;
//import com.leyou.search.service.SearchService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.support.AbstractElasticsearchRepository;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = LeyouSearchApplication.class)
//public class ElasticsearchTest {
//
//    @Autowired
//    private GoodsRepository goodsRepository;
//
//    @Autowired
//    private ElasticsearchTemplate template;
//    @Autowired
//    private GoodsClient goodsClient;
//    @Autowired
//    private SearchService searchService;
//
//    //    @Test
////    public void createIndex(){
////        // 创建索引库，以及映射
////        this.template.createIndex(Goods.class);
////        this.template.putMapping(Goods.class);
////    }
//    @Test
//    public void createIndex(){
//        // 创建索引
//        this.template.createIndex(Goods.class);
//        // 配置映射
//        this.template.putMapping(Goods.class);
//        Integer page = 1;
//        Integer rows = 100;
//
//        do {
//            // 分批查询spuBo
//            PageResult<SpuBo> pageResult = this.goodsClient.querySpuBoByPage( null,true,page, rows);
//            // 遍历spubo集合转化为List<Goods>
//            List<Goods> goodsList = pageResult.getItems().stream().map(spuBo -> {
//                try {
//                    return this.searchService.buildGoods((Spu) spuBo);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                return null;
//            }).collect(Collectors.toList());
//            this.goodsRepository.saveAll(goodsList);
//
//            // 获取当前页的数据条数，如果是最后一页，没有100条
//            rows = pageResult.getItems().size();
//            // 每次循环页码加1
//            page++;
//        } while (rows == 100);
//    }
//}
