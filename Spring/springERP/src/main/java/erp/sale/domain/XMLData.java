package erp.sale.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@XmlRootElement(name="data")
@AllArgsConstructor
@NoArgsConstructor
public class XMLData {
	private Goods_data data;
	
	@XmlElements({@XmlElement(name="goods_data")})
	public Goods_data getData() {
		return data;
	}

	public void setData(Goods_data data) {
		this.data = data;
	}
}
