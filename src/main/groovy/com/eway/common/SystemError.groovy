package com.eway.common



// need to auto generate: getter, setter, toString, equals, constructor
class SystemError {
    private Date timestamp
    private Integer code
    private String message, details, path

    Date getTimestamp() {
        return timestamp
    }

    void setTimestamp(Date timestamp) {
        this.timestamp = timestamp
    }

    Integer getCode() {
        return code
    }

    void setCode(Integer code) {
        this.code = code
    }

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }

    String getDetails() {
        return details
    }

    void setDetails(String details) {
        this.details = details
    }

    String getPath() {
        return path
    }

    void setPath(String path) {
        this.path = path
    }

    static class Builder {
        private Integer code
        private String message, details, path

        Builder(Integer code) {
            this.code = code
        }

        Builder() {}

        Builder withMessage(String message) {
            this.message = message
            return this
        }

        Builder details(String details) {
            this.details = details
            return this
        }

        Builder fromPath(String path) {
            this.path = path
            return this
        }

        SystemError build() {
            SystemError error = new SystemError()
            error.setCode(this.code)
            error.setMessage(this.message)
            error.setTimestamp(new Date())
            error.setDetails(this.details)
            error.setPath(this.path)
            return error
        }
    }
}
