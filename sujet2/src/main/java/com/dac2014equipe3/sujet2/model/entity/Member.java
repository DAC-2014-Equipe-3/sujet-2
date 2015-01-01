package com.dac2014equipe3.sujet2.model.entity;
import com.dac2014equipe3.sujet2.vo.MemberVo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Member", catalog = "sujet2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Member.findAll", query = "SELECT m FROM Member m"),
    @NamedQuery(name = "Member.findByMemberId", query = "SELECT m FROM Member m WHERE m.memberId = :memberId"),
    @NamedQuery(name = "Member.findByMemberEmail", query = "SELECT m FROM Member m WHERE m.memberEmail = :memberEmail"),
    @NamedQuery(name = "Member.findByMemberLogin", query = "SELECT m FROM Member m WHERE m.memberLogin = :memberLogin"),
    @NamedQuery(name = "Member.findByMemberPassword", query = "SELECT m FROM Member m WHERE m.memberPassword = :memberPassword"),
    @NamedQuery(name = "Member.findByMemberIsAdmin", query = "SELECT m FROM Member m WHERE m.memberIsAdmin = :memberIsAdmin"),
    @NamedQuery(name = "Member.findByMemberJoiningDate", query = "SELECT m FROM Member m WHERE m.memberJoiningDate = :memberJoiningDate"),
    @NamedQuery(name = "Member.findByMemberLastname", query = "SELECT m FROM Member m WHERE m.memberLastname = :memberLastname"),
    @NamedQuery(name = "Member.findByMemberFirstname", query = "SELECT m FROM Member m WHERE m.memberFirstname = :memberFirstname"),
    @NamedQuery(name = "Member.findByMemberBirthday", query = "SELECT m FROM Member m WHERE m.memberBirthday = :memberBirthday"),
    @NamedQuery(name = "Member.findByMemberNationality", query = "SELECT m FROM Member m WHERE m.memberNationality = :memberNationality"),
    @NamedQuery(name = "Member.findByMemberSex", query = "SELECT m FROM Member m WHERE m.memberSex = :memberSex"),
    @NamedQuery(name = "Member.findByMemberProfession", query = "SELECT m FROM Member m WHERE m.memberProfession = :memberProfession"),
    @NamedQuery(name = "Member.findByMemberIsSuppressed", query = "SELECT m FROM Member m WHERE m.memberIsSuppressed = :memberIsSuppressed")})
public class Member implements Serializable, IEntity<MemberVo> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "memberId")
    private Integer memberId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "memberEmail")
    private String memberEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "memberLogin")
    private String memberLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "memberPassword")
    private String memberPassword;
    @Column(name = "memberIsAdmin")
    private Boolean memberIsAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "memberJoiningDate")
    @Temporal(TemporalType.DATE)
    private Date memberJoiningDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "memberLastname")
    private String memberLastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "memberFirstname")
    private String memberFirstname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "memberBirthday")
    @Temporal(TemporalType.DATE)
    private Date memberBirthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "memberNationality")
    private String memberNationality;
    @Size(max = 45)
    @Column(name = "memberSex")
    private String memberSex;
    @Size(max = 45)
    @Column(name = "memberProfession")
    private String memberProfession;
    @Column(name = "memberIsSuppressed")
    private Boolean memberIsSuppressed;
    @JoinTable(name = "Member_creates_Project", joinColumns = {
        @JoinColumn(name = "creatorId", referencedColumnName = "memberId")}, inverseJoinColumns = {
        @JoinColumn(name = "projectId", referencedColumnName = "projectId")})
    @ManyToMany
    private List<Project> projectList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member1")
    private List<MemberbacksProject> memberbacksProjectList;

    public Member() {
    }

    public Member(Integer memberId) {
        this.memberId = memberId;
    }

    public Member(Integer memberId, String memberEmail, String memberLogin, String memberPassword, Date memberJoiningDate, String memberLastname, String memberFirstname, Date memberBirthday, String memberNationality) {
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberLogin = memberLogin;
        this.memberPassword = memberPassword;
        this.memberJoiningDate = memberJoiningDate;
        this.memberLastname = memberLastname;
        this.memberFirstname = memberFirstname;
        this.memberBirthday = memberBirthday;
        this.memberNationality = memberNationality;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberLogin() {
        return memberLogin;
    }

    public void setMemberLogin(String memberLogin) {
        this.memberLogin = memberLogin;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public Boolean getMemberIsAdmin() {
        return memberIsAdmin;
    }

    public void setMemberIsAdmin(Boolean memberIsAdmin) {
        this.memberIsAdmin = memberIsAdmin;
    }

    public Date getMemberJoiningDate() {
        return memberJoiningDate;
    }

    public void setMemberJoiningDate(Date memberJoiningDate) {
        this.memberJoiningDate = memberJoiningDate;
    }

    public String getMemberLastname() {
        return memberLastname;
    }

    public void setMemberLastname(String memberLastname) {
        this.memberLastname = memberLastname;
    }

    public String getMemberFirstname() {
        return memberFirstname;
    }

    public void setMemberFirstname(String memberFirstname) {
        this.memberFirstname = memberFirstname;
    }

    public Date getMemberBirthday() {
        return memberBirthday;
    }

    public void setMemberBirthday(Date memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    public String getMemberNationality() {
        return memberNationality;
    }

    public void setMemberNationality(String memberNationality) {
        this.memberNationality = memberNationality;
    }

    public String getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(String memberSex) {
        this.memberSex = memberSex;
    }

    public String getMemberProfession() {
        return memberProfession;
    }

    public void setMemberProfession(String memberProfession) {
        this.memberProfession = memberProfession;
    }

    public Boolean getMemberIsSuppressed() {
        return memberIsSuppressed;
    }

    public void setMemberIsSuppressed(Boolean memberIsSuppressed) {
        this.memberIsSuppressed = memberIsSuppressed;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<MemberbacksProject> getMemberbacksProjectList() {
        return memberbacksProjectList;
    }

    public void setMemberbacksProjectList(List<MemberbacksProject> memberbacksProjectList) {
        this.memberbacksProjectList = memberbacksProjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberId != null ? memberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Member)) {
            return false;
        }
        Member other = (Member) object;
        if ((this.memberId == null && other.memberId != null) || (this.memberId != null && !this.memberId.equals(other.memberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.Member[ memberId=" + memberId + " ]";
    }

    @Override
    public MemberVo toVo() {
        MemberVo vo = new MemberVo();
        
        vo.setMemberId(memberId);
        vo.setMemberEmail(memberEmail);
        vo.setMemberLogin(memberLogin);
        vo.setMemberPassword(memberPassword);
        vo.setMemberIsAdmin(memberIsAdmin);
        vo.setMemberJoiningDate(memberJoiningDate);
        vo.setMemberBirthday(memberBirthday);
        vo.setMemberFirstname(memberFirstname);
        vo.setMemberLastname(memberLastname);
        vo.setMemberNationality(memberNationality);
        vo.setMemberSex(memberSex);
        vo.setMemberProfession(memberProfession);
        vo.setMemberIsSuppressed(memberIsSuppressed);
        
        return vo;
    }

}
