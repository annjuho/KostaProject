package erp.sale.domain;

import javax.xml.bind.annotation.XmlElement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Goods_data {

	private String goods_category;
	private String goodsnm;
	private String goodscd;
	private int goods_price;
	private String usestock;
	private String totstock;
	
	@XmlElement
	public String getGoods_category() {
		return goods_category;
	}
	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}
	@XmlElement
	public String getGoodsnm() {
		return goodsnm;
	}
	public void setGoodsnm(String goodsnm) {
		this.goodsnm = goodsnm;
	}
	@XmlElement
	public String getGoodscd() {
		return goodscd;
	}
	public void setGoodscd(String goodscd) {
		this.goodscd = goodscd;
	}
	@XmlElement
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	@XmlElement
	public String getUsestock() {
		return usestock;
	}
	public void setUsestock(String usestock) {
		this.usestock = usestock;
	}
	@XmlElement
	public String getTotstock() {
		return totstock;
	}
	public void setTotstock(String i) {
		this.totstock = i;
	}
	

}
