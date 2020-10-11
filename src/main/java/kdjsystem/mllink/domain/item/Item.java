package kdjsystem.mllink.domain.item;

import com.sun.jdi.NativeMethodException;
import kdjsystem.mllink.domain.Category;
import kdjsystem.mllink.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
@Getter @Setter
public abstract class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private Integer price;
    private Integer stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    /**
     * 제고 수량 증가..
     *
     */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /**
     *
     * 재고 감소..
     * @throws NotEnoughStockException
     */
    public void removeStock(int quantity) throws NotEnoughStockException {
        int restStock =  this.stockQuantity - quantity;
        if(restStock< 0){
            throw  new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

}
