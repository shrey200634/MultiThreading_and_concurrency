public class Test2 {
    public static void main(String[] args) {
        
        Student eStudent= new Student() {

            @Override
            public String getBio(String name) {
                return name + "is engineering student ";
               
            }
            
        };

        Student law = (String name )-> {name + "is laww" ;};
        String bio = eStudent.getBio("Shrey");
        System.out.println(bio);
    }
    
}
