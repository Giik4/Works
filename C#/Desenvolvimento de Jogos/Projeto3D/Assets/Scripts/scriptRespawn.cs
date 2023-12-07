using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class scriptRespawn : MonoBehaviour
{
    public static int npcCont = 4;
    public GameObject npc;

    public bool respawn = false;


    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {   
        if((npcCont<4) && (respawn)){
            Invoke("spawn",5);
            npcCont++;
        }
    }

    void spawn(){
        
        int x = 0;
            
        if(Random.value>0.5f)        
            x = 32;
        else
            x = 20;
            

        Vector3 posicao = new Vector3(x,2,-40);

        Instantiate(npc, posicao, Quaternion.identity);
        
    }
}
