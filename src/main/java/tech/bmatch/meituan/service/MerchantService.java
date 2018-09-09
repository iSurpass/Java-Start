package tech.bmatch.meituan.service;

import tech.bmatch.meituan.model.Merchant;

import java.util.List;

public interface MerchantService {

    public void add(Merchant merchant);

    public List<Merchant> search(double lon,double lat);
}
