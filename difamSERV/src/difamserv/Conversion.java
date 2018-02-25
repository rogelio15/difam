package difamserv;

public class Conversion {

    String unidades[] = {"", "Un", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", "Once", "Doce", "Trece", "Catorce", "Quince", "Dieciseis", "Diecisiete", "Dieciocho", "Diecinueve", "Veinte"};
    String decenas[] = {"", "", "Veinti", "Treinta", "Cuarenta", "Cincuenta", "Sesenta", "Setenta", "Ochenta", "Noventa", "Cien"};
    String centenas[] = {"", "Ciento", "Doscientos", "Trecientos", "Cuatrocientos", "Quinientos", "Seiscientos", "Setecientos", "Ochocientos", "Novecientos", "Mil"};

    public String numeroALetra(String cantidad) {
        int numero = Integer.parseInt(cantidad);
        System.out.println(numero);
        cantidad = "" + numero;
        String letras = "";
        int decena = 0;
        int unidad = 0;
        int centena = 0;
        int decenaM = 0;
        int unidadM = 0;
        int centenaM = 0;
        String num = "";
        String numM = "";
        String cadenaM1 = "";
        String cadenaM2 = "";

        //Separacion de cantidad en parteS
        if (numero <= 20) {
            letras = unidades[numero];
        } else {
            if (numero < 100) {
                decena = Integer.parseInt(((Character) ((cantidad).charAt(0))).toString());
                unidad = Integer.parseInt(((Character) ((cantidad).charAt(1))).toString());

                letras = ((decenas[decena]).toString()) + ((numero < 30 || (numero % 10 == 0)) ? ("" + ((unidades[unidad]).toString()).toLowerCase()) : (" y " + ((unidades[unidad]).toString())));

            } else {
                if (numero < 1000) {
                    centena = Integer.parseInt(((Character) ((cantidad).charAt(0))).toString());
                    decena = Integer.parseInt(((Character) ((cantidad).charAt(1))).toString());
                    unidad = Integer.parseInt(((Character) ((cantidad).charAt(2))).toString());

                    if (numero == 100) {
                        letras = decenas[10];
                    } else {
                        num = (((Character) ((cantidad).charAt(1))).toString()) + (((Character) ((cantidad).charAt(2))).toString());
                        Conversion x = new Conversion();

                        letras = ((centenas[centena]).toString()) + " " + (x.numeroALetra(num)).toString();
                    }
                } else {
                    if (numero == 1000) {
                        letras = "Un" + " " + centenas[(centenas.length - 1)];
                    } else {
                        Conversion w = new Conversion();
                        if (numero < 10000) {
                            letras = unidades[(Integer.parseInt(((Character) ((cantidad).charAt(0))).toString()))] + " Mil ";

                            centena = Integer.parseInt(((Character) ((cantidad).charAt(1))).toString());
                            decena = Integer.parseInt(((Character) ((cantidad).charAt(2))).toString());
                            unidad = Integer.parseInt(((Character) ((cantidad).charAt(3))).toString());

                            numM = (((Integer) (centena)).toString()) + (((Integer) (decena)).toString()) + (((Integer) (unidad)).toString());

                            cadenaM1 = (w.numeroALetra(numM)).toString();

                            letras += cadenaM1;
                        } else {
                            if (numero < 100000) {
                                decena = Integer.parseInt(((Character) ((cantidad).charAt(0))).toString());
                                unidad = Integer.parseInt(((Character) ((cantidad).charAt(1))).toString());
                                centenaM = Integer.parseInt(((Character) ((cantidad).charAt(2))).toString());
                                decenaM = Integer.parseInt(((Character) ((cantidad).charAt(3))).toString());
                                unidadM = Integer.parseInt(((Character) ((cantidad).charAt(4))).toString());

                                cadenaM1 = (((Integer) (decena)).toString()) + (((Integer) (unidad)).toString());
                                cadenaM2 = (((Integer) (centenaM)).toString()) + (((Integer) (decenaM)).toString()) + (((Integer) (unidadM)).toString());

                                letras = w.numeroALetra(cadenaM1) + " Mil ";
                                letras += w.numeroALetra(cadenaM2);
                            } else {
                                if (numero < 1000000) {
                                    centena = Integer.parseInt(((Character) ((cantidad).charAt(0))).toString());
                                    decena = Integer.parseInt(((Character) ((cantidad).charAt(1))).toString());
                                    unidad = Integer.parseInt(((Character) ((cantidad).charAt(2))).toString());

                                    centenaM = Integer.parseInt(((Character) ((cantidad).charAt(3))).toString());
                                    decenaM = Integer.parseInt(((Character) ((cantidad).charAt(4))).toString());
                                    unidadM = Integer.parseInt(((Character) ((cantidad).charAt(5))).toString());

                                    cadenaM1 = (((Integer) (centena)).toString()) + (((Integer) (decena)).toString()) + (((Integer) (unidad)).toString());
                                    cadenaM2 = (((Integer) (centenaM)).toString()) + (((Integer) (decenaM)).toString()) + (((Integer) (unidadM)).toString());

                                    letras = w.numeroALetra(cadenaM1) + " Mil ";
                                    letras += w.numeroALetra(cadenaM2);
                                }
                            }
                        }

                    }
                }
            }
        }
        return letras;
    }

    public String letra(String precio) {
        double dp = Double.parseDouble(precio);
        precio = (String.format("%10.2f", dp).trim());
        String enteros = (precio.substring(0, precio.indexOf('.'))).trim();
        String centavos = precio.substring(precio.indexOf('.') + 1);
        String letra = numeroALetra(enteros);

        int num = Integer.parseInt(enteros);
        String conversion = letra.toUpperCase() + ((num == 1) ? " PESO " + centavos + "/100 M.N." : " PESOS " + centavos + "/100 M.N.");
        return conversion;
    }
    
      //mètodo para reemplazar las "," en los valores double.
//      public String remmplazaCaracter(String campo) {
//        String caracter = "";
//        if (campo.contains(",")) {
//            caracter = campo.replace(',', '.');
//        }
//        return caracter;
//    }
}
