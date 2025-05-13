package loverflower.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import loverflower.model.Entity.Status;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Order> order_id;
    @Column(nullable = false)
    private String method;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(nullable = false)
    private Long amount;
}
