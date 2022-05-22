package server;

public class AccountServerImpl implements AccountServer{
    private int usersLimit;

    public AccountServerImpl() {
        this.usersLimit = 10;
    }

    @Override
    public int getUsersLimit(){
        return usersLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit){
        this.usersLimit = usersLimit;
    }
}
