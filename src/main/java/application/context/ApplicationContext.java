package application.context;
import connection.util.Connector;
import repository.*;
import service.*;
import java.sql.Connection;

public class ApplicationContext {

    private static final Connection CONNECTION;


    //REPOSITORY
    private static final UserRepository USER_REPOSITORY;
    private static final Shareholder_BrandRepository SHAREHOLDER_BRAND_REPOSITORY;
    private static final BrandRepository BRAND_REPOSITORY;
    private static final CategoryRepository CATEGORY_REPOSITORY;
    private static final ProductRepository PRODUCT_REPOSITORY;
    private static final ShareholderRepository SHAREHOLDER_REPOSITORY;


    //SERVICE
    private static final UserService USER_SERVICE;
    private static final ShareholderService SHAREHOLDER_SERVICE;
    private static final CategoryService CATEGORY_SERVICE;
    private static final ProductService PRODUCT_SERVICE;
    private static final Shareholder_BrandService SHAREHOLDER_BRAND_SERVICE;
    private static final BrandService BRAND_SERVICE;


    static {
        CONNECTION = Connector.getConnection();

        USER_REPOSITORY = new UserRepository(CONNECTION);
        USER_SERVICE = new UserService(USER_REPOSITORY);

        SHAREHOLDER_REPOSITORY = new ShareholderRepository(CONNECTION);
        SHAREHOLDER_SERVICE = new ShareholderService(SHAREHOLDER_REPOSITORY);

        SHAREHOLDER_BRAND_REPOSITORY = new Shareholder_BrandRepository(CONNECTION);
        SHAREHOLDER_BRAND_SERVICE = new Shareholder_BrandService(SHAREHOLDER_BRAND_REPOSITORY);

        PRODUCT_REPOSITORY = new ProductRepository(CONNECTION);
        PRODUCT_SERVICE = new ProductService(PRODUCT_REPOSITORY);

        CATEGORY_REPOSITORY = new CategoryRepository(CONNECTION);
        CATEGORY_SERVICE = new CategoryService(CATEGORY_REPOSITORY);

        BRAND_REPOSITORY = new BrandRepository(CONNECTION);
        BRAND_SERVICE = new BrandService(BRAND_REPOSITORY);
    }


    //GETTER
    public static UserService getUserService() {
        return USER_SERVICE;
    }
    public static ShareholderService getShareholderService(){return SHAREHOLDER_SERVICE;}
    public static Shareholder_BrandService getShareholderBrandService(){return SHAREHOLDER_BRAND_SERVICE;}
    public static CategoryService getCategoryService(){return CATEGORY_SERVICE;}
    public static BrandService getBrandService(){return BRAND_SERVICE;}
    public static ProductService getProductService(){return PRODUCT_SERVICE;}

}
