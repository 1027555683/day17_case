package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }
    @Override
    public User login(User user){
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectUser(String[] uids) {
        if(uids != null && uids.length > 0){
            //遍历数组
            for (String uid : uids) {
                //2.调用删除
                dao.delete(Integer.parseInt(uid));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage<=0){
            currentPage = 1;
        }

        //1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //2.设置参数

        pb.setRows(rows);             //设置一页显示多少条数据

        //3.调用dao查询总记录数
        int totalCount =  dao.findTotalCount(condition);
        pb.setTatalCount(totalCount); //设置总数据数目

        //5.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        if (currentPage > totalPage){
            currentPage = totalPage;
        }
        pb.setCurrentPage(currentPage); //设置当前页码
        //4.调用dao查询List集合
        //计算开始记录索引
        int start = (currentPage-1)*rows;
        List<User> list = dao.findByPage(start,rows);
        pb.setList(list);//把查询出来的list集合传入pb中
        return pb;
    }
}
