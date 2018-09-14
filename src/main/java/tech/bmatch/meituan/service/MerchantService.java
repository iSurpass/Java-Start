package tech.bmatch.meituan.service;

import tech.bmatch.meituan.model.Merchant;
import tech.bmatch.meituan.model.MerchantSearchParam;

import java.util.List;

public interface MerchantService {

    public void init();

    public void add(Merchant merchant);

    public List<Merchant> search(MerchantSearchParam merchantSearchParam);
}
