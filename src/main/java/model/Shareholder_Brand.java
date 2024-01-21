package model;
import lombok.*;
import service.Shareholder_BrandService;
import java.sql.Connection;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Shareholder_Brand {
private int shareholder_id;
private int brand_id;
}

