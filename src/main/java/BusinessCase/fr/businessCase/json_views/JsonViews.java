package BusinessCase.fr.businessCase.json_views;

public class JsonViews {

    public interface UserMinimalView {}
    public interface UserShowView extends
            UserMinimalView,
            ListingMinimalView,
            FavoriteView {}

    public interface FavoriteView {}

    public interface ListingMinimalView {}
    public interface ListingListView extends ListingMinimalView {}
    public interface ListingShowView extends ListingListView {}

    public interface ChargingMinimalView {}
    public interface BrandListView extends ChargingMinimalView {}
    public interface ChargingshowView extends
            ChargingMinimalView,
            ModelMinimalView {}

    public interface ModelMinimalView {}
    public interface ChargingView extends ChargingMinimalView {}
}
