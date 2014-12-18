/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dac2014equipe3.sujet2.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jummartinezro
 */
@Entity
@Table(name = "Media", catalog = "sujet2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m"),
    @NamedQuery(name = "Media.findByMediaId", query = "SELECT m FROM Media m WHERE m.mediaId = :mediaId"),
    @NamedQuery(name = "Media.findByMediaURL", query = "SELECT m FROM Media m WHERE m.mediaURL = :mediaURL"),
    @NamedQuery(name = "Media.findByMediaName", query = "SELECT m FROM Media m WHERE m.mediaName = :mediaName"),
    @NamedQuery(name = "Media.findByMediaDescription", query = "SELECT m FROM Media m WHERE m.mediaDescription = :mediaDescription")})
public class Media implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mediaId")
    private Integer mediaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mediaURL")
    private String mediaURL;
    @Size(max = 45)
    @Column(name = "mediaName")
    private String mediaName;
    @Size(max = 45)
    @Column(name = "mediaDescription")
    private String mediaDescription;
    @JoinColumn(name = "Project_projectId", referencedColumnName = "projectId")
    @ManyToOne(optional = false)
    private Project projectprojectId;

    public Media() {
    }

    public Media(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Media(Integer mediaId, String mediaURL) {
        this.mediaId = mediaId;
        this.mediaURL = mediaURL;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaDescription() {
        return mediaDescription;
    }

    public void setMediaDescription(String mediaDescription) {
        this.mediaDescription = mediaDescription;
    }

    public Project getProjectprojectId() {
        return projectprojectId;
    }

    public void setProjectprojectId(Project projectprojectId) {
        this.projectprojectId = projectprojectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaId != null ? mediaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dac2014equipe3.sujet2.model.entity.Media[ mediaId=" + mediaId + " ]";
    }

}
