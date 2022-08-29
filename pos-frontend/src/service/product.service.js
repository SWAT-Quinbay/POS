import axios from "axios";
import { baseUrl } from "@/utils/urls"

export const addNewProduct = ({ productData , successCallback ,  errrorCallback}) => {
  axios
    .post(`${baseUrl}/add` , productData)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}

export const updateProductDetail = ({ productData , successCallback ,  errrorCallback}) => {
    axios
      .put(`${baseUrl}`,productData)
      .then((response) => {
        successCallback && successCallback(response);
      })
      .catch((e) => {
        errrorCallback && errrorCallback(e);
      });
  }

  export const deleteProductData = ({ productId , successCallback ,  errrorCallback}) => {
    axios
      .delete(`${baseUrl}/${productId}`)
      .then((response) => {
        successCallback && successCallback(response);
      })
      .catch((e) => {
        errrorCallback && errrorCallback(e);
      });
  }

  export const getProductByName = ({ searchKey, successCallback, errorCallback }) => {
    axios
      .get(`${baseUrl}/search?name=${searchKey}&page=0&size=20`)
      .then((response) => {
        successCallback && successCallback(response);
      })
      .catch((e) => {
        errorCallback && errorCallback(e);
      });
  }

export const getInventory = ({ successCallback, errrorCallback }) => {
  axios
    .get(`${baseUrl}/all?page=0&size=100`)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}


