package com.xiaoran.elasticsearch.demo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoran.elasticsearch.demo.mapper.HotelMapper;
import com.xiaoran.elasticsearch.demo.model.pojo.Hotel;
import com.xiaoran.elasticsearch.demo.service.IHotelService;
import org.springframework.stereotype.Service;

@Service
public class HotelService extends ServiceImpl<HotelMapper, Hotel> implements IHotelService {
}
