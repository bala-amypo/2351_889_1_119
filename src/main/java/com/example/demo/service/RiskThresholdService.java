import java.util.*;
package com.example.demo.service;
package com.example.demo.model.RiskThreshold;

public interface RiskThresholdService extends RiskThreshold
{
    RiskThreshold createThreshold(RiskThreshold threshold);
    RiskThreshold updateThreshold(Long id,RiskThreshold threshold);
    RiskThreshold getActiveThreshold();
    RiskThreshold getThresholdById(Long id);
    List<RiskThreshold>getAllThresholds();


}