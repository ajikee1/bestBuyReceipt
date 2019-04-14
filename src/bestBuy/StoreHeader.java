package bestBuy;

public class StoreHeader {

    private String street_addr;
    private String zip_code;
    private String state_code;
    private String phone_num;
    private String store_num;

    public StoreHeader(String street_addr, String zip_code, String state_code, String phone_num, String store_num)
    {
        this.street_addr = street_addr;
        this.zip_code = zip_code;
        this.state_code = state_code;
        this.phone_num = phone_num;
        this.store_num = store_num;
    }

    public String getState_code() {
        return state_code;
    }

    public String getStreet_addr() {
        return street_addr;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public String getStore_num() {
        return store_num;
    }

}
