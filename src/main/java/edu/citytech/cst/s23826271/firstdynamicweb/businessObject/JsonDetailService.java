package edu.citytech.cst.s23826271.firstdynamicweb.businessObject;

import com.citytech.basicsecurity.model.User;
import edu.citytech.cst.s23826271.firstdynamicweb.model.JsonUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JsonDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String useId) throws UsernameNotFoundException {
       UserBO userBO = new UserBO();
        User userInfo = userBO.getUserInfo(useId);
        if(useId == null)
            throw new UsernameNotFoundException("invalid user id "+userInfo.getUserId());

        return new JsonUserDetail(userInfo);
    }
}
