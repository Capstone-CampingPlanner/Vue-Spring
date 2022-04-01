package com.example.vuespring.service;

import com.example.vuespring.constant.ErrorCode;
import com.example.vuespring.data.Menu;
import com.example.vuespring.dto.ProductDetailDTO;
import com.example.vuespring.error.GeneralException;
import com.example.vuespring.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.example.vuespring.constant.Constants.DELETE_N;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public ProductDetailDTO getProductDetail(String menuname) {
        return modelMapper.map(getDeveloperByMenuname(menuname), ProductDetailDTO.class);
    }

    private Menu getDeveloperByMenuname(String menuname) {
        return menuRepository.findByMenuAndDeleteYN(menuname, DELETE_N).orElseThrow(() -> new GeneralException(ErrorCode.BAD_REQUEST));
    }
}
