package com.blacknebula.bonitaTheme.model;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author hazem
 */
@Entity
@Table(name = "theme")
public class Theme {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tenantid")
    private Long tenantId;

    @Column(name = "isdefault")
    private Boolean isDefault;

    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] content;

    @Lob
    @Column(name = "csscontent")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] cssContent;

    private String type;

    @Column(name = "lastupdatedate ")
    private long lastUpdateDate;

    public Theme() {
    }

    private Theme(Builder builder) {
        setTenantId(builder.tenantId);
        setId(builder.id);
        isDefault = builder.isDefault;
        setContent(builder.content);
        setCssContent(builder.cssContent);
        setType(builder.type);
        setLastUpdateDate(builder.lastUpdateDate);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(long lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getCssContent() {
        return cssContent;
    }

    public void setCssContent(byte[] cssContent) {
        this.cssContent = cssContent;
    }


    public static final class Builder {
        private Long tenantId;
        private Long id;
        private Boolean isDefault;
        private byte[] content;
        private byte[] cssContent;
        private String type;
        private long lastUpdateDate;

        private Builder() {
        }

        public Builder setTenantId(Long val) {
            tenantId = val;
            return this;
        }

        public Builder setId(Long val) {
            id = val;
            return this;
        }

        public Builder setIsDefault(Boolean val) {
            isDefault = val;
            return this;
        }

        public Builder setContent(byte[] val) {
            content = val;
            return this;
        }

        public Builder setCssContent(byte[] val) {
            cssContent = val;
            return this;
        }

        public Builder setType(String val) {
            type = val;
            return this;
        }

        public Builder setLastUpdateDate(long val) {
            lastUpdateDate = val;
            return this;
        }

        public Theme build() {
            return new Theme(this);
        }
    }
}
