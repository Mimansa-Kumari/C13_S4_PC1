package com.customerService.Customer.Service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT ,reason = "Customer With The Specified Id Does Not Exist!!!" )
public class CustomerWithSpecifiedIdAlreadyExist extends Exception {
}
