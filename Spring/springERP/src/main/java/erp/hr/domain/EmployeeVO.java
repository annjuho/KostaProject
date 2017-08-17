package erp.hr.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class EmployeeVO implements UserDetails{
	
	private static final long serialVersionUID = -4086869747130410600L;

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	private String emp_id;
	@Getter @Setter private String e_name;
	@Getter @Setter private int e_age;
	@Getter @Setter private Date e_hiredate;
	@Getter @Setter private String dept_id;
	@Getter @Setter private String e_profile_pic;
	@Getter @Setter private int e_sal;
	@Getter @Setter private String e_address;
	@Getter @Setter private String e_email;
	@Getter @Setter private String phone_number;
	@Getter @Setter private String position_id;
	@Getter @Setter private String job_id;
	@Getter @Setter private String duty_id;
	@Getter @Setter private String e_pwd;
	@Getter @Setter private MultipartFile uploadFile;
    @Setter private String path="/resources/hr/images/";
	@Getter @Setter private String fullPath;
	
	private Set<GrantedAuthority> authorities;
	
	public EmployeeVO(String emp_id, String e_name, int e_age, Date e_hiredate, String dept_id, String e_profile_pic,
			int e_sal, String e_address, String e_email, String phone_number, String position_id, String job_id,
			String duty_id, String e_pwd, Collection<? extends GrantedAuthority> authorities) {
		this.emp_id = emp_id;
		this.e_name = e_name;
		this.e_age = e_age;
		this.e_hiredate = e_hiredate;
		this.dept_id = dept_id;
		this.e_profile_pic = e_profile_pic;
		this.e_sal = e_sal;
		this.e_address = e_address;
		this.e_email = e_email;
		this.phone_number = phone_number;
		this.position_id = position_id;
		this.job_id = job_id;
		this.duty_id = duty_id;
		this.e_pwd = e_pwd;
		this.authorities = Collections.unmodifiableSortedSet(sortAuthorities(authorities));
	}
	public String getPath(){
		return path+e_profile_pic;
	}
	public void makeFullPath(){
		fullPath=path+e_profile_pic;
	}

	public EmployeeVO(String emp_id, String e_pwd, String e_name, String dept_id, Collection<? extends GrantedAuthority> authorities){
		this.emp_id = emp_id;
		this.e_pwd = e_pwd;
		this.e_name = e_name;
		this.dept_id = dept_id;
		this.authorities = Collections.unmodifiableSortedSet(sortAuthorities(authorities));
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities){
		this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
	}
	
	@Override
	public String getPassword() {
		return e_pwd;
	}
	@Override
	public String getUsername() {
		return getEmp_id();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities){
		Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
		
		SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<GrantedAuthority>(new AuthorityComparator());
		
		for(GrantedAuthority grantedAuthority : authorities){
			Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
			
			sortedAuthorities.add(grantedAuthority);
		}
		
		return sortedAuthorities;
	}
}

class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable{
	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
	
	public int compare(GrantedAuthority g1, GrantedAuthority g2){
		if(g2.getAuthority() == null){
			return -1;
		}
		
		if(g1.getAuthority() == null){
			return 1;
		}
		
		return g1.getAuthority().compareTo(g2.getAuthority());
	}
}

















