package com.xiattong.batis.mapper;

import com.xiattong.batis.domain.Blog;

/**
 * @Author: xiattong
 */
public interface BlogMapper {
    /**
     * 根据主键查询文章
     * @param bid
     * @return
     */
    public Blog selectBlogById(Integer bid);
    public Blog selectBlogById2(Integer bid,Integer authorId);

}
