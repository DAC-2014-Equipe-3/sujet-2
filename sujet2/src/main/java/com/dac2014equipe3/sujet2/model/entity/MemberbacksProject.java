package com.dac2014equipe3.sujet2.model.entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Member_backs_Project", catalog = "sujet2", schema = "")
@NamedQueries({
        @NamedQuery(name = "MemberbacksProject.findAll", query = "SELECT m FROM MemberbacksProject m"),
        @NamedQuery(name = "MemberbacksProject.findByMemberbacksProjectPK", query = "SELECT m FROM MemberbacksProject m WHERE (m.memberbacksProjectPK.backerId = :backerId) AND (m.memberbacksProjectPK.projectId = :projectId)"),
        @NamedQuery(name = "MemberbacksProject.findByBackerId", query = "SELECT m FROM MemberbacksProject m WHERE m.memberbacksProjectPK.backerId = :backerId"),
        @NamedQuery(name = "MemberbacksProject.findByProjectId", query = "SELECT m FROM MemberbacksProject m WHERE m.memberbacksProjectPK.projectId = :projectId"),
        @NamedQuery(name = "MemberbacksProject.findByRewardId", query = "SELECT m FROM MemberbacksProject m WHERE m.memberbacksProjectPK.rewardrewardId = :rewardrewardId"),
        @NamedQuery(name = "MemberbacksProject.findByPledgedEuros", query = "SELECT m FROM MemberbacksProject m WHERE m.pledgedEuros = :pledgedEuros"),
        @NamedQuery(name = "MemberbacksProject.findByBackingDate", query = "SELECT m FROM MemberbacksProject m WHERE m.backingDate = :backingDate")})

public class MemberbacksProject implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MemberbacksProjectPK memberbacksProjectPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pledgedEuros")
    private int pledgedEuros;
    @Basic(optional = false)
    @NotNull
    @Column(name = "backingDate")
    @Temporal(TemporalType.DATE)
    private Date backingDate;
    @JoinColumn(name = "backerId", referencedColumnName = "memberId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Member member1;
    @JoinColumn(name = "projectId", referencedColumnName = "projectId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project project;
    @JoinColumn(name = "Reward_rewardId", referencedColumnName = "rewardId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Reward reward;

    public MemberbacksProject() {
    }

    public MemberbacksProject(MemberbacksProjectPK memberbacksProjectPK) {
        this.memberbacksProjectPK = memberbacksProjectPK;
    }

    public MemberbacksProject(MemberbacksProjectPK memberbacksProjectPK, int pledgedEuros, Date backingDate) {
        this.memberbacksProjectPK = memberbacksProjectPK;
        this.pledgedEuros = pledgedEuros;
        this.backingDate = backingDate;
    }

    public MemberbacksProject(int backerId, int projectId, int rewardrewardId) {
        this.memberbacksProjectPK = new MemberbacksProjectPK(backerId, projectId, rewardrewardId);
    }

    public MemberbacksProjectPK getMemberbacksProjectPK() {
        return memberbacksProjectPK;
    }

    public void setMemberbacksProjectPK(MemberbacksProjectPK memberbacksProjectPK) {
        this.memberbacksProjectPK = memberbacksProjectPK;
    }

    public int getPledgedEuros() {
        return pledgedEuros;
    }

    public void setPledgedEuros(int pledgedEuros) {
        this.pledgedEuros = pledgedEuros;
    }

    public Date getBackingDate() {
        return backingDate;
    }

    public void setBackingDate(Date backingDate) {
        this.backingDate = backingDate;
    }

    public Member getMember1() {
        return member1;
    }

    public void setMember1(Member member1) {
        this.member1 = member1;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberbacksProjectPK != null ? memberbacksProjectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberbacksProject)) {
            return false;
        }
        MemberbacksProject other = (MemberbacksProject) object;
        if ((this.memberbacksProjectPK == null && other.memberbacksProjectPK != null) || (this.memberbacksProjectPK != null && !this.memberbacksProjectPK.equals(other.memberbacksProjectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.MemberbacksProject[ memberbacksProjectPK=" + memberbacksProjectPK + " ]";
    }

}
