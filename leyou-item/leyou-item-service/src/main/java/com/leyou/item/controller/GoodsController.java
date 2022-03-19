package com.leyou.item.controller;

import com.leyou.common.pojo.PageResult;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.pojo.SpuBo;
import com.leyou.item.pojo.SpuDetail;
import com.leyou.item.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
//@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("spu/page")
    public ResponseEntity<PageResult<SpuBo>> querySpuBoByPage(
            @RequestParam(value = "key", required = false)String key,
            @RequestParam(value = "saleable", required = false)Boolean saleable,
            @RequestParam(value = "page", defaultValue = "1")Integer page,
            @RequestParam(value = "rows", defaultValue = "5")Integer rows
    ){
        PageResult<SpuBo> pageResult = this.goodsService.querySpuBoByPage(key, saleable, page, rows);
        if(CollectionUtils.isEmpty(pageResult.getItems())){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pageResult);
    }
    @PostMapping("goods")
    public ResponseEntity<Void> saveGoods(@RequestBody SpuBo spuBo){
        this.goodsService.saveGoods(spuBo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("spu/detail/{spuId}")
    public ResponseEntity<SpuDetail> querySpuDetailBySpuId(@PathVariable("spuId")Long spuId){
        SpuDetail spuDetail = this.goodsService.querySpuDetailBySpuId(spuId);
        if (spuDetail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(spuDetail);
    }
    @GetMapping("sku/list")
    public ResponseEntity<List<Sku>> querySkusBySpuId(@RequestParam("id")Long spuId){
        List<Sku> skus = this.goodsService.querySkusBySpuId(spuId);
        if (CollectionUtils.isEmpty(skus)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(skus);
    }
    @PutMapping("goods")
    public ResponseEntity<Void> updateGoods(@RequestBody SpuBo spuBo){
        this.goodsService.updateGoods(spuBo);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
//    @GetMapping("goods/spu/page")
//    public PageResult<SpuBo>  querySpuByPage(
//            @RequestParam(value = "key", required = false) String key,
//            @RequestParam(value = "saleable", defaultValue = "true") Boolean saleable,
//
//                @RequestParam(value = "page", defaultValue = "1") Integer page,
//            @RequestParam(value = "rows", defaultValue = "5") Integer rows
//    ){
//        PageResult<SpuBo> names = this.goodsService.querySpuBoByPage(key,saleable,page,rows);
//        return names;
//    }
//    @GetMapping("goods/sku/list")
//    public ResponseEntity<List<Sku>>   querySkuBySpuId(@RequestParam("id") Long id){
//        List<Sku> names=this.goodsService.querySkusBySpuId(id);
//        if (CollectionUtils.isEmpty(names)) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(names);
//    }
//    @GetMapping("goods/spu/detail/{id}")
//    public ResponseEntity<SpuDetail> querySpuDetailById(@PathVariable("id") Long id) {
//        SpuDetail names=this.goodsService.querySpuDetailBySpuId(id);
//        return ResponseEntity.ok(names);
//    }
}
