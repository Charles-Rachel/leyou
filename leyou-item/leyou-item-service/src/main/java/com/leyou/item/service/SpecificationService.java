package com.leyou.item.service;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecificationService {

    @Resource
    private SpecGroupMapper groupMapper;
    @Resource
    private SpecParamMapper paramMapper;

    /**
     * 根据条件查询规格参数
     * @param gid
     * @return
     */
    public List<SpecParam> queryParams(Long gid) {
        SpecParam param = new SpecParam();
        param.setGroupId(gid);
        return this.paramMapper.select(param);
    }
    /**
     * 根据分类id查询分组
     * @param cid
     * @return
     */
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return this.groupMapper.select(specGroup);
    }

    public void addGroupsByCid(SpecGroup specGroup) {
        this.groupMapper.insert(specGroup);
    }

    public void addGroupsById(SpecGroup specGroup) {
        this.groupMapper.updateByPrimaryKey(specGroup);
    }

    public void deleteGroupsById(Long id) {
        this.groupMapper.deleteByPrimaryKey(id);
    }

    public void addParamByCid(SpecParam specParam) {
        this.paramMapper.insert(specParam);
    }

    public void updateParamById(SpecParam specParam) {
        this.paramMapper.updateByPrimaryKey(specParam);
    }

    public void deleteParamById(Long id) {
        this.paramMapper.deleteByPrimaryKey(id);
    }
}