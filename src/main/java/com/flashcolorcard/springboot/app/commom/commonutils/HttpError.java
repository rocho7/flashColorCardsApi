package com.flashcolorcard.springboot.app.commom.commonutils;

import lombok.Generated;

public class HttpError {
    private String id;
    private String campo;
    private String codError;
    private String msgError;

    @Generated
    public String getId() {
        return this.id;
    }

    @Generated
    public String getCampo() {
        return this.campo;
    }

    @Generated
    public String getCodError() {
        return this.codError;
    }

    @Generated
    public String getMsgError() {
        return this.msgError;
    }

    @Generated
    public void setId(final String id) {
        this.id = id;
    }

    @Generated
    public void setCampo(final String campo) {
        this.campo = campo;
    }

    @Generated
    public void setCodError(final String codError) {
        this.codError = codError;
    }

    @Generated
    public void setMsgError(final String msgError) {
        this.msgError = msgError;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof HttpError)) {
            return false;
        } else {
            HttpError other = (HttpError)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$id = this.getId();
                    Object other$id = other.getId();
                    if (this$id == null) {
                        if (other$id == null) {
                            break label59;
                        }
                    } else if (this$id.equals(other$id)) {
                        break label59;
                    }

                    return false;
                }

                Object this$campo = this.getCampo();
                Object other$campo = other.getCampo();
                if (this$campo == null) {
                    if (other$campo != null) {
                        return false;
                    }
                } else if (!this$campo.equals(other$campo)) {
                    return false;
                }

                Object this$codError = this.getCodError();
                Object other$codError = other.getCodError();
                if (this$codError == null) {
                    if (other$codError != null) {
                        return false;
                    }
                } else if (!this$codError.equals(other$codError)) {
                    return false;
                }

                Object this$msgError = this.getMsgError();
                Object other$msgError = other.getMsgError();
                if (this$msgError == null) {
                    if (other$msgError != null) {
                        return false;
                    }
                } else if (!this$msgError.equals(other$msgError)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof HttpError;
    }

    @Generated
    public int hashCode() {
//        int PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        Object $campo = this.getCampo();
        result = result * 59 + ($campo == null ? 43 : $campo.hashCode());
        Object $codError = this.getCodError();
        result = result * 59 + ($codError == null ? 43 : $codError.hashCode());
        Object $msgError = this.getMsgError();
        result = result * 59 + ($msgError == null ? 43 : $msgError.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        String var10000 = this.getId();
        return "HttpError(id=" + var10000 + ", campo=" + this.getCampo() + ", codError=" + this.getCodError() + ", msgError=" + this.getMsgError() + ")";
    }

    @Generated
    public HttpError() {
    }

    @Generated
    public HttpError(final String id, final String campo, final String codError, final String msgError) {
        this.id = id;
        this.campo = campo;
        this.codError = codError;
        this.msgError = msgError;
    }
}
