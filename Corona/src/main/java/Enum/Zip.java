package Enum;

//not required for jdbc assignment
public enum Zip {
    Alabama("35801-35816"),
    Alaska("99501-99524"),
    Arizona("85001-85055"),
    Arkansas("72201-72217"),
    California("94203-94209");
//    Colorado,
//    Connecticut,
//    Delaware,
//    Florida,
//    Georgia,
//    Hawaii,
//    Idaho,
//    Illinois,
//    Indiana,
//    Iowa,
//    Kansas,
//    Kentucky,
//    Louisiana,
//    Maine,
//    Maryland,
//    Massachusetts,
//    Michigan,
//    Minnesota,
//    Mississippi,
//    Missouri,
//    Montana,
//    Nebraska,
//    Nevada,
//    New_Hampshire,
//    New_Jersey,
//    New_Mexico,
//    New_York,
//    North_Carolina,
//    North_Dakota,
//    Ohio,
//    Oklahoma,
//    Oregon,
//    Pennsylvania,
//    Rhode_Island,
//    South_Carolina,
//    South_Dakota,
//    Tennessee,
//    Texas,
//    Utah,
//    Vermont,
//    Virginia,
//    Washington,
//    West_Virginia,
//    Wisconsin,
//    Wyoming

    private final String zipCode;

    Zip(String s) {
        zipCode = s;
    }

    public String getZipCode() {
        return this.zipCode;
    }
}
