package loverflower.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import loverflower.model.Entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Order> order_id;
    @Column(nullable = false)
    private String  address;
    @CreatedDate
    private Timestamp Created_date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private String tracking_number;
}
