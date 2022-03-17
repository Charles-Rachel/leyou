package com.leyou.item.controller;

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;
    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
//    @GetMapping("params")
//    public ResponseEntity<List<SpecParam>> queryParams(@RequestParam("gid")Long gid){
//        List<SpecParam>  params = this.specificationService.queryParams(gid);
//        if (CollectionUtils.isEmpty(params)){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(params);
//    }
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> queryParams(
            @RequestParam(value = "gid", required = false)Long gid,
            @RequestParam(value = "cid", required = false)Long cid,
            @RequestParam(value = "generic", required = false)Boolean generic,
            @RequestParam(value = "searching", required = false)Boolean searching
    ){

        List<SpecParam> params = this.specificationService.queryParams(gid, cid, generic, searching);

        if (CollectionUtils.isEmpty(params)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(params);
    }
    @PostMapping("param")
    public ResponseEntity<Void> addParamBygid(@RequestBody SpecParam specParam){
        this.specificationService.addParamByCid(specParam);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("param")
    public ResponseEntity<Void> updateParamById(@RequestBody SpecParam specParam){
        this.specificationService.updateParamById(specParam);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("param/{id}")
    public ResponseEntity<Void> deleteParamById(@PathVariable("id") Long id){
        this.specificationService.deleteParamById(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    /**
     * 根据分类id查询分组
     * @param cid
     * @return
     */
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> queryGroupsByCid(@PathVariable("cid")Long cid){
        List<SpecGroup> groups = this.specificationService.queryGroupsByCid(cid);
        if (CollectionUtils.isEmpty(groups)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(groups);
    }
    @PostMapping("group")
    public ResponseEntity<Void> addGroupByCid(@RequestBody SpecGroup specGroup){
        this.specificationService.addGroupsByCid(specGroup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("group")
    public ResponseEntity<Void> updateGroupById(@RequestBody SpecGroup specGroup){
        this.specificationService.addGroupsById(specGroup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("group/{id}")
    public ResponseEntity<Void> deleteGroupById(@PathVariable("id") Long id){
        this.specificationService.deleteGroupsById(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}