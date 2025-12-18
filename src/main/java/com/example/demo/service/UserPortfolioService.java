import java.util.*;
package com.example.demo.service;
package com.example.demo.model.UserPortfolio;

public interface UserPortfolioService extends UserPortfolio
{
    UserPortfolio createPortfolio( UserPortfolio portfolio);
     UserPortfolio updatePortfolio(Long id, UserPortfolio portfolio);
     UserPortfolio getPortfolioById(Long id);
     UserPortfolio getPortfolioByUser(Long userId);
     void deactivatePortfolio(Long id);


}