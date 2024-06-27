package com.tobeto.blog.service.responses;

import com.tobeto.blog.service.paging.BasePagingModel;

import java.util.ArrayList;
import java.util.List;

public class GetListResponse<T> extends BasePagingModel {
    private List<T> _items;

    public List<T> get_items() {
        if(_items == null){
            _items = new ArrayList<>();
        }

        return _items;
    }

    public void set_items(List<T> items) {
        _items = items;
    }
}
