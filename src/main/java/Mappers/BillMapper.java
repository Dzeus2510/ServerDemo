package Mappers;

import DTO.BillAddDTO;
import DTO.BillEditDTO;
import DTO.BillWithProductCountDTO;
import com.example.ProjectDemo.Models.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillMapper {

    @Mapping(source = "customer.customerName", target = "customerName")
    @Mapping(target = "productCount", expression = "java(bill.getBillProducts() != null ? bill.getBillProducts().size() : 0)")
    BillWithProductCountDTO toDto(Bill bill);

    List<BillWithProductCountDTO> toDtoList(List<Bill> bills);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(target = "productIds", expression = "java(mapProducts(bill))" )
    BillAddDTO toAddDto(Bill bill);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(target = "productIds", expression = "java(mapProducts(bill))" )
    BillEditDTO toEditDto(Bill bill);

    default List<Integer> mapProducts(Bill bill) {
        if (bill.getBillProducts() == null) return java.util.Collections.emptyList();
        return bill.getBillProducts()
                .stream()
                .map(bp -> bp.getProduct().getId())
                .collect(java.util.stream.Collectors.toList());
    }
}
