package br.com.castudio.sistema_agendamento.aplication.dto.message;

public record MessageResponse<T>(boolean sucess, String msg, T data){

    public static <T> MessageResponse<T> sucessWithData(String msg, T data){
        return new MessageResponse<>(true, msg, data);
    }

    public static <T> MessageResponse<T> sucessWithoutData(String msg){
        return new MessageResponse<>(true, msg, null);
    }

    public static <T> MessageResponse<T> errorWithoutData(String msg){
        return new MessageResponse<>(false, msg, null);
    }

    public static <T> MessageResponse<T> errorWithData(String msg, T data){
        return new MessageResponse<>(false, msg, data);
    }

}
