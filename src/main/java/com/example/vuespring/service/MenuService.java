package com.example.vuespring.service;

import com.example.vuespring.constant.ErrorCode;
import com.example.vuespring.data.Menu;
import com.example.vuespring.dto.ProductDetailDTO;
import com.example.vuespring.error.GeneralException;
import com.example.vuespring.repository.MenuRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static com.example.vuespring.constant.Constants.DELETE_N;

@Service
@AllArgsConstructor
//@RequiredArgsConstructor
public class MenuService {

    private MenuRepository menuRepository;
    private ModelMapper modelMapper;

    public List<Menu> list() {
        List<Menu> list = menuRepository.findAll();

        return list;
    }

    public ProductDetailDTO view(String menuname) throws Exception {
        Optional<Menu> menu = menuRepository.findByMenuname(menuname);

        if(menu.isPresent()) {
            return new ProductDetailDTO(menu.get());
        } else {
            throw new NotFoundException("리소스를 찾을 수 없습니다.");
        }
    }



//    @Transactional
//    public ProductDetailDTO getProductDetail(String menuname) {
//        return modelMapper.map(getDeveloperByMenuname(menuname), ProductDetailDTO.class);
//    }
//
//    private Menu getDeveloperByMenuname(String menuname) {
//        return menuRepository.findByMenuAndDeleteYN(menuname, DELETE_N).orElseThrow(() -> new GeneralException(ErrorCode.BAD_REQUEST));
//    }


}
