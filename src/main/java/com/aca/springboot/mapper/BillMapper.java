package com.aca.springboot.mapper;

import com.aca.springboot.entities.bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BillMapper {
    /**
     * 查询所有账单信息
     * @return 账单信息列表
     */
    public List<bill> findAllBill();

    /**
     * 根据账单状态查询
     * @param state 账单状态
     * @return 账单列表
     */
    public List<bill> findBillByState(@Param("state") String state);

    /**
     * 添加账单信息
     * @param map 账单信息的映射
     * @return  执行是否成功
     */
    public int addBill(Map map);

    public void deleteBill();


}
