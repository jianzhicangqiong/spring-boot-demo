package com.example.data.cache.service;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.Cached;
import com.example.data.cache.key.CacheKey;
import com.example.data.cache.vo.UserVO;


public interface UserService {

    // @Cached(name = CacheKey.USER_KEY, key = "#userVO.id")
    @Cached(name = CacheKey.USER_KEY)
    @CacheRefresh(refresh = 10)
    void save(UserVO userVO);

    // @CacheInvalidate(name = CacheKey.USER_KEY, key = "#id")
    @CacheInvalidate(name = CacheKey.USER_KEY)
    void deleteById(Long id);

    // @CacheUpdate(name = CacheKey.USER_KEY, key = "#userVO.id", value = "#userVO")
    // @CacheUpdate(name = CacheKey.USER_KEY, key = "#userVO.id", value = "#userVO")
    void updateById(UserVO userVO);

    // @Cached(name = CacheKey.USER_KEY, key = "#id")
    @Cached(name = CacheKey.USER_KEY)
    UserVO getById(Long id);

}
