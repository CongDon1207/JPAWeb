package vn.iotstar.entity;


import java.io.Serializable;
import java.sql.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int id;

    @Column(name = "Email", columnDefinition = "nvarchar(100) not null")
    @Email(message = "Email không hợp lệ")
    @NotEmpty(message = "Email không được để trống")
    private String email;

    @Column(name = "UserName", columnDefinition = "nvarchar(50) not null")
    @NotEmpty(message = "Tên đăng nhập không được để trống")
    @Size(max = 50, message = "Tên đăng nhập không được vượt quá 50 ký tự")
    private String userName;

    @Column(name = "FullName", columnDefinition = "nvarchar(100) not null")
    @NotEmpty(message = "Họ tên không được để trống")
    @Size(max = 100, message = "Họ tên không được vượt quá 100 ký tự")
    private String fullName;

    @Column(name = "Password", columnDefinition = "nvarchar(255) not null")
    @NotEmpty(message = "Mật khẩu không được để trống")
    private String password;

    @Column(name = "Images", columnDefinition = "nvarchar(500) null")
    private String images;

    @Column(name = "RoleId")
    private int roleid;

    @Column(name = "Phone", columnDefinition = "nvarchar(15) null")
    private String phone;

    @Column(name = "CreatedDate", columnDefinition = "datetime")
    private Date createdDate;

    public User() {
        super();
    }

    public User(int id, String email, String userName, String fullName, String password, String images, int roleid,
                String phone, Date createdDate) {
        super();
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.images = images;
        this.roleid = roleid;
        this.phone = phone;
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName
                + ", password=" + password + ", images=" + images + ", roleid=" + roleid + ", phone=" + phone
                + ", createdDate=" + createdDate + "]";
    }
}

