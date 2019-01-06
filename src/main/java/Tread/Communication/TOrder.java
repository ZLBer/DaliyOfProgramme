package Tread.Communication;

public class TOrder {
    private Integer oid;

    private Integer userid;

    private String finaladdress;

    private Integer frequencyid;

    private Double price;

    private Integer state;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFinaladdress() {
        return finaladdress;
    }

    public void setFinaladdress(String finaladdress) {
        this.finaladdress = finaladdress == null ? null : finaladdress.trim();
    }

    public Integer getFrequencyid() {
        return frequencyid;
    }

    public void setFrequencyid(Integer frequencyid) {
        this.frequencyid = frequencyid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}